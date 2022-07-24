pipeline {
    agent any
    stages {
        stage ('Information') {
            steps {
                println "**** Beginning stage execution: " + "Information ****"
                println "Build number: " + "${BUILD_NUMBER}"
                println "Build ID: " + "${BUILD_ID}"
                println "Build Tag: " + "${BUILD_TAG}"
                println "Build URL: " + "${BUILD_URL}"
                println "Node Name: " + "${NODE_NAME}"
                println "Job Name: " + "${JOB_NAME}"
                println "Workspace Path: " + "${WORKSPACE}"
                println "Git Commit: " + "${GIT_COMMIT}"
                println "Git Branch: " + "${GIT_BRANCH}"
                println "PATH Variable: " + "${PATH}"
                println "JAVA_HOME Variable: " + "${JAVA_HOME}"
                println "MAVEN_HOME Variable: " + "${M2_HOME}"
                println "**** Stage complete: " + "Information ****"
            }
        }
        stage('Maven Clean') {
            steps {
                println "**** Beginning stage execution: " + "Maven Clean ****"
                sh 'mvn clean'
                println "**** Stage complete: " + "Maven Clean ****"
            }
        }
        stage('Maven Compile') {
            steps {
                println "**** Beginning stage execution: " + "Maven Compile ****"
                sh 'mvn compile'
                println "**** Stage complete: " + "Maven Compile ****"
            }
        }
        stage('Maven Test') {
            steps {
                println "**** Beginning stage execution: " + "Maven Test ****"
                script {
                    def zalenJobName = "FA_Pipeline_Zalenium_Test"
                    def cbtJobName = "FA_Pipeline_CBT_Test"
                    if (zalenJobName == "${env.JOB_NAME}") {
                        println "Executing regressionSuiteZalenium.xml"
                        sh 'mvn test -Dsurefire.suiteXmlFiles=regressionSuiteZalenium.xml'
                    } else if (cbtJobName == "${env.JOB_NAME}"){
                        println "Executing regressionSuiteCBT.xml"
                        sh 'mvn test -Dsurefire.suiteXmlFiles=regressionSuiteCBT.xml'
                    }
                }
                println "**** Stage complete: " + "Maven Test ****"
            }
        }
    }
}