node("master") {
    stage("Checkout Source Code") {
        properties([pipelineTriggers([[$class: 'GitHubPushTrigger'], pollSCM('H/15 * * * *')])])
        checkout scm
    }

    stage("Build Code") {
        sleep(new Random().nextInt(10) * 1000)
        sh "mvn compile"
    }    

    stage("Unit tests") {
        sh "mvn compile"
    }

    stage("Code quality check") {
        sh "mvn compile"
    }    

    stage("Deploy artefacts to Nexus") {
        sh "mvn compile"
    }    

    stage("Deploy app to target environment") {
        sh "mvn compile"
    }    

    stage("Testing ...") {
        sh "mvn compile"
    }        
}