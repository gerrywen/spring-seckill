pipeline {
    agent any 
    environment {
    	GIT_PATH="/alidata/www/spring-seckill"
    	SCRIPT_PATH="/alidata/www/shell"
    }
    stages {
    	stage('环境检查') {
            steps {
                echo 'Hello, Git'
                sh 'git --version'
                echo 'Hello, Maven'
                sh 'mvn --version'
                echo 'Hello, JDK'
                sh 'java -version'
                echo '环境检查完毕'
            }
        }
        stage('更新git代码') {
            steps {
            	dir("${GIT_PATH}") {
                    echo "进入文件夹:${GIT_PATH},开始拉取代码"
                	sh 'pwd'
                	sh 'git checkout master'
                	sh 'git pull'
                	echo "拉取最新代码完成"
                }
            }
        }
        stage('编译maven') {
            steps {
				dir("${GIT_PATH}") {
                    echo "进入文件夹:${GIT_PATH},开始编译"
                    sh  'pwd'
                	// todo:待完善
                	echo "编译完成"
                }
            }
        }
        stage('构建镜像') {
            steps {
				dir("${SCRIPT_PATH}") {
                    echo "进入文件夹:${SCRIPT_PATH},开始构建镜像"
                    sh  'pwd'
                	// todo:待完善
                	echo "构建镜像完成"
                }
            }
        }
    }
}
