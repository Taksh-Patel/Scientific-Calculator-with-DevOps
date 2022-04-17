//properties([pipelineTriggers([githubPush()])])
pipeline {
		agent any
    stages {
        stage('Git Pull') {
            steps {
		git url: 'https://github.com/Taksh-Patel/Scientific-Calculator-with-DevOps.git', branch: 'main',
                credentialsId: 'git'
            }
        }
        stage('Maven Build and Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t takshpatel/calculatordevops:latest .'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                sh 'docker push takshpatel/calculatordevops:latest'
                }
            }
        }
        stage('Clean Docker Images') {
            steps {
                sh 'docker rmi -f takshpatel/calculatordevops'
            }
        }
        stage('Ansible Deploy') {
            steps {
                ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'calculator-deploy.yml'
            }
        }
    }
}
