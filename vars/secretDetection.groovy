def call() {
    script {
        sh """
            curl -Lo trufflehog.tar.gz "https://github.com/trufflesecurity/trufflehog/releases/download/v3.81.11/trufflehog_3.81.11_linux_\$(dpkg --print-architecture).tar.gz"
            tar -xzf trufflehog.tar.gz && mv trufflehog /bin/ && rm trufflehog.tar.gz
        """
        sh "trufflehog git file://. --since-commit main --fail"
    }
}
