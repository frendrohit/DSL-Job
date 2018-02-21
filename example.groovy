job('example') {
  scm {
        github('OpsTree/Spring3HibernateAppWithGradle', 'master')
    }
  steps {
        batchFile('gradlew.bat build')
    }
  publishers {
        cobertura('**/target/site/cobertura/coverage.xml') {
            failNoReports(true)
            sourceEncoding('ASCII')

            // the following targets are added by default to check the method, line and conditional level coverage
            methodTarget(80, 0, 0)
            lineTarget(80, 0, 0)
            conditionalTarget(70, 0, 0)
        }
  }
}