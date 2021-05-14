# PDF/A-3 Generation with Mustang and FOP - Performance Evaluation

This project is a performance evaluation of PDF/A-3 file generation using Mustang library http://mustangproject.org/  and Apache FOP https://xmlgraphics.apache.org/fop/

## Prerequisites
- OpenJDK11 with hotspot as the JVM

## How to run
1. Clone the repository.
2. Run `pom.xml` as `Maven build`, where goal is set to `eclipse:eclipse`.

### 1. To simply generate a PDF/A-3 file
1. Run `src/main/java/pdfa3eval/Main.java`
2. When this is successfully done `generatedA3.pdf` file will be generated in the root directory.

### 2. For performance testing with JMH
1. Run `src/main/java/pdfa3eval/BenchmarkTesting.java`

### 3. To validate the generated PDF/A-3 file
1. Run `src/test/java/PdfValidator.java`
