# Automated End-to-End Test for Google Search

This repository contains an automated end-to-end test for Google Search using TestNG, Selenium, Java, and Maven. The test can run on Windows and Linux environments in both original and headless forms.

## Test Description

This automated test performs the following steps:

1. **Open Google Website**
   - Launches the Google website.

2. **Perform Search**
   - Types a configurable search phrase (specified under test resources in config.properties file).
   - Submits the search query.

3. **Verify Search Results**
   - Checks if search results are displayed on the page.

4. **Click on First Non-Ad Result**
   - Clicks on the first real (non-Ad) search result.

5. **Verify Opened Page**
   - Ensures that the page is successfully opened.

6. **Verify Initial Search Phrase**
   - Confirms that the page contains the initial search phrase.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Logging](#logging)


## Getting Started

To get started with this project, follow the instructions below

### Prerequisites

Before you begin, make sure you have the following installed:

- Java 17 or higher
- Maven 3.8.6 or higher
- Chrome browser
- Git

### Installation
- Download and install [Java](https://www.java.com/download/ie_manual.jsp) available and make sure the system environmental variable points to it
- Download and install [Maven](https://maven.apache.org/download.cgi) available and make sure the system environmental variable points to it
- Download and install the latest version of [Chrome Browser](https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwjug5KTpNeBAxUUp9UKHVE8BnQYABAAGgJ3cw&ase=2&gclid=Cj0KCQjw1OmoBhDXARIsAAAYGSHujsSoTwk0H1G7RgC-1Pt3qm6gKJ5Kq07F8MZ9crllSjTjT6n--GMaAiCoEALw_wcB&ei=e6waZYeqK46Fxc8P6JCxmAE&ohost=www.google.com&cid=CAESV-D2_-jWE4O2wHQzNOFVTiBHSdK3zxPb9VpJaB9TTTT0T-UU1wLVcYhH7kAx_vYPoWrWIsXMohwDB20guWl4a2rdIllyOs6d_u2VxSxRDhyggFpbHO02ww&sig=AOD64_3zvyT3UcU2AemBlSRNSMyyog_BNQ&q&sqi=2&nis=4&adurl&ved=2ahUKEwjH04qTpNeBAxWOQvEDHWhIDBMQ0Qx6BAgNEAE)
- Download and install the latest version of [Git](https://git-scm.com/downloads) available and make sure the system environmental variable points to it

## Usage

**Clone the Repository** 
   ```
    git clone https://github.com/PythonNovice5/AkirolabsTest.git
    cd AkirolabsTest
  ```
## Running Tests

  **1. Running via maven command on Windows/Linux** 
  
  ```   mvn test   ```

  **2. Running via maven command on Windows/Linux as HeadLess browser**
  
  ```   mvn test -Dheadless=true   ```
  
  **3. Running the test using .bat file on Windows**

 ```   run_test.bat   ```

 **4. Running test using .bat file on Windows as Headless browser**
 
 ```   run_test.bat -Dheadless=true   ```

 **5. Running a test using .sh file on Linux**

 ```   ./run_test.sh   ```

 **6. Running a test using .sh file on Linux as Headless browser**
 
 ```   ./run_test.sh -Dheadless=true   ```  

## Logging

This project uses the SLF4J (Simple Logging Facade for Java) framework for logging. SLF4J serves as a simple facade or abstraction for various logging frameworks, allowing you to use different logging implementations without modifying your code.

  **Logging Levels**
  In this project, we use various logging levels to categorize log messages based on their severity and importance. The following are the available log levels:

  - **TRACE**: Fine-grained details.
- **DEBUG**: Debugging info.
- **INFO**: General updates.
- **WARN**: Potential issues.
- **ERROR**: Severe errors.
- **FATAL**: Critical, app terminates.

### Current Configuration

Level: `INFO` (in `logback.xml`) under test/resources.

To change, edit `logback.xml`.


  

