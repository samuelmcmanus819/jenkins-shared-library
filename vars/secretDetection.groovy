def call() {
    script {
        sh """
            curl -Lo trufflehog.tar.gz "https://github.com/trufflesecurity/trufflehog/releases/download/v3.82.12/trufflehog_3.82.12_linux_amd64.tar.gz"
            tar -xzf trufflehog.tar.gz && rm trufflehog.tar.gz
        """
        sh "./trufflehog git file://. --since-commit main --fail"
    }
}
