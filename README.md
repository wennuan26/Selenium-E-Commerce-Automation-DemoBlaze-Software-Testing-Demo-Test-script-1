# Selenium-E-Commerce-Automation-DemoBlaze-Software-Testing-Demo-Test-script-1
A robust Selenium WebDriver project built in Java to demonstrate end-to-end testing on the DemoBlaze e-commerce platform. This project follows a structured approach to automate user workflows, from registration to product selection.

🚀 Key Features
Dynamic User Creation: Automatically generates unique usernames using system timestamps to ensure the registration test passes on every execution.

Synchronization: Implements WebDriverWait (Explicit Waits) to handle AJAX-based modals and JavaScript alerts.

Alert Handling: Seamlessly manages browser-level JavaScript pop-ups for registration confirmation.

Task-Based Structure: Organized into 5 distinct modules for easy readability and maintenance.

📋 Automation Tasks
Task 1: Navigation – Launches Chrome and navigates to the landing page, verifying the site identity.

Task 2: Registration – Opens the "Sign Up" modal, inputs credentials, and handles the success alert.

Task 3: Authentication – Performs login using the account created in the previous step and verifies the "Welcome" session.

Task 4: Product Search – Navigates through the 'Laptops' category to locate and verify specific item details (Sony vaio i5).

Task 5: Cleanup – Gracefully closes the browser and terminates the WebDriver session.

🛠️ Tech Stack
Language: Java 21

Automation Tool: Selenium WebDriver (v4.17.0)

Testing Framework: JUnit 4 (for Assertions)

Browser: Google Chrome (via Selenium Manager)

📥 Installation & Usage
Clone the repository:

Bash
git clone https://github.com/yourusername/SeleniumAssignment02.git
Open the project in Eclipse IDE.

Ensure the Selenium JAR files are added to the Build Path.

Run saucedemo.java as a Java Application.

