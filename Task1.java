 // ---------- TASK 1: OPEN WEBSITE ----------
    public static void openWebsite() {
        System.out.println("Executing Task 1: Opening Website...");
        driver.get("https://www.demoblaze.com/");
        
        String title = driver.getTitle();
        System.out.println("Website Title: " + title);
        
        // Verify the page loaded correctly
        Assert.assertTrue("Title should contain STORE", title.contains("STORE"));
    }
