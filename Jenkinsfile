pipeline {
    agent none
    stages {
        stage('Checkout Source Code') {
           agent {
                label "master"
            }
            steps {
                script {                
                    properties([pipelineTriggers([[$class: 'GitHubPushTrigger'], pollSCM('H/15 * * * *')])])
                }    
                checkout scm
                script {
                    pom = readMavenPom file: 'pom.xml'
                    currentBuild.displayName = "v" + pom.version
                }                                                
            }            
        } 
        stage('Building Source Code') {
           agent {
                label "master"
            }
            steps {
                sh "mvn compile"
            }            
        }                    
        stage('Checking...') {
            parallel {
                stage('Running Unit Tests') {
                    agent {
                        label "master"
                    }
                    steps {
                        sh "mvn test"
                    }
                }
                stage('Sonar Quality check') {
                    agent {
                        label "master"
                    }
                    steps {
                        withSonarQubeEnv('sonar') {
                            sh "mvn install"
                        }
                    }
                    post {
                        always {
                            echo "Checks OK"
                        }
                    }
                }
            }
        }

        stage('Deploy artefacts to Nexus') {
           agent {
                label "master"
            }
            steps {
                sh "mvn deploy"
            }            
        }  

        stage('Deploy app to target environment') {
           agent {
                label "master"
            }
            steps {
                sh "mvn compile"
            }            
        }  

        stage('Testing ...') {
           agent {
                label "master"
            }
            steps {
                sh "mvn compile"
            }            
        }  
    }
}