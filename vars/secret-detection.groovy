def call() {
    node {
        stage('Secret Scan') {
            withEnv(["TRUFFLEHOG_VERSION=3.81.11"])
            sh ```
                curl -Lo trufflehog.tar.gz "https://github.com/trufflesecurity/trufflehog/releases/download/v${TRUFFLEHOG_VERSION}/trufflehog_${TRUFFLEHOG_VERSION}_linux_$(dpkg --print-architecture).tar.gz"
                tar -xzf trufflehog.tar.gz && mv trufflehog /bin/ && rm trufflehog.tar.gz
            ```
            sh "trufflehog git file://. --since-commit main --fail"
        }
    }
}