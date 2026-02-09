// ---------- TASK 5: CLOSE BROWSER ----------
    public static void closeBrowser() {
        System.out.println("Executing Task 5: Closing Browser...");
        if (driver != null) {
            driver.quit();
            System.out.println("Test execution finished successfully.");
        }
    }
