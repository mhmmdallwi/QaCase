package wemine

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

/**
 * Shared WeMine automation helpers. Keep app-specific locators centralized here.
 * Replace semantic XPath fallbacks with stable accessibility/resource IDs from Katalon Spy.
 */
class WeMineKeywords {
    static TestObject mobileText(String label) {
        TestObject o = new TestObject("mobile_${safe(label)}")
        String q = xpathLiteral(label)
        String qLower = xpathLiteral(label.toLowerCase())
        o.addProperty('xpath', ConditionType.EQUALS,
            "//*[@text=${q} or @content-desc=${q} or @hint=${q} or @label=${q} or contains(translate(@text,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower})]")
        return o
    }

    static TestObject mobileField(String label) {
        TestObject o = new TestObject("field_${safe(label)}")
        String q = xpathLiteral(label)
        String qLower = xpathLiteral(label.toLowerCase())
        o.addProperty('xpath', ConditionType.EQUALS,
            "//*[@text=${q} or @content-desc=${q} or @hint=${q} or @label=${q} or contains(translate(@text,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@hint,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@resource-id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower})]")
        return o
    }

    static TestObject webText(String label) {
        TestObject o = new TestObject("web_${safe(label)}")
        String q = xpathLiteral(label)
        String qLower = xpathLiteral(label.toLowerCase())
        o.addProperty('xpath', ConditionType.EQUALS,
            "//*[normalize-space(text())=${q} or @aria-label=${q} or @placeholder=${q} or @value=${q} or contains(translate(normalize-space(text()),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower})]")
        return o
    }

    @Keyword
    static void startMobile() {
        String appPath = System.getenv('WEMINE_APP_PATH')
        if (!appPath) KeywordUtil.markFailedAndStop('Set WEMINE_APP_PATH to the test APK path before running mobile tests.')
        Mobile.startApplication(appPath, false)
        Mobile.delay(2)
    }

    @Keyword
    static void closeMobile() { Mobile.closeApplication() }

    @Keyword
    static void completeMicrosoftSignIn() {
        TestObject email = mobileField('Email')
        boolean emailPrompt = Mobile.verifyElementExist(email, 3, FailureHandling.OPTIONAL)
        if (!emailPrompt) return // Existing Microsoft session or tenant-specific auth screen.
        String msUser = System.getenv('WEMINE_MS_USERNAME')
        String msPassword = System.getenv('WEMINE_MS_PASSWORD')
        if (!msUser || !msPassword) KeywordUtil.markFailedAndStop('Microsoft sign-in prompt is visible. Set WEMINE_MS_USERNAME and WEMINE_MS_PASSWORD for a dedicated test account, or complete this step manually.')
        Mobile.setText(email, msUser, 10)
        try { tapMobile('Next', 5) } catch (Exception ignored) { tapMobile('Continue', 5) }
        TestObject password = mobileField('Password')
        Mobile.waitForElementPresent(password, 10)
        Mobile.setText(password, msPassword, 10)
        tapMobile('Sign in', 10)
        try { tapMobile('No', 5) } catch (Exception ignored) { /* stay-signed-in prompt may not appear */ }
    }


    @Keyword
    static void tapMobile(String label, int timeout = 10) {
        TestObject o = mobileText(label)
        Mobile.waitForElementPresent(o, timeout)
        Mobile.tap(o, timeout)
    }

    @Keyword
    static void tapMobileField(String label, int timeout = 10) {
        TestObject o = mobileField(label)
        Mobile.waitForElementPresent(o, timeout)
        Mobile.tap(o, timeout)
    }

    @Keyword
    static void setMobileField(String label, String value, int timeout = 10) {
        TestObject o = mobileField(label)
        Mobile.waitForElementPresent(o, timeout)
        Mobile.tap(o, timeout)
        Mobile.setText(o, value, timeout)
    }

    @Keyword
    static void verifyMobileText(String label, int timeout = 10) {
        Mobile.verifyElementExist(mobileText(label), timeout)
    }

    @Keyword
    static void verifyMobileTextNotPresent(String label, int timeout = 3) {
        Mobile.verifyElementNotExist(mobileText(label), timeout)
    }

    @Keyword
    static void selectMobileOption(String fieldLabel, String optionLabel) {
        tapMobileField(fieldLabel)
        tapMobile(optionLabel)
    }

    @Keyword
    static void startWeb() {
        openWebApp()
        TestObject loginUser = webField('Username')
        if (WebUI.verifyElementPresent(loginUser, 3, FailureHandling.OPTIONAL)) {
            String user = System.getenv('WEMINE_TEST_USERNAME')
            if (!user) KeywordUtil.markFailedAndStop('Set WEMINE_TEST_USERNAME to a valid WeMine test user before running authenticated web tests.')
            WebUI.setText(loginUser, user)
            try { tapWeb('Continue', 5) } catch (Exception ignored) { tapWeb('Next', 5) }
            completeMicrosoftSignInWeb()
        }
    }

    @Keyword
    static void tapWeb(String label, int timeout = 10) {
        TestObject o = webText(label)
        WebUI.waitForElementClickable(o, timeout)
        WebUI.click(o)
    }

    @Keyword
    static void setWebField(String label, String value, int timeout = 10) {
        TestObject o = webField(label)
        WebUI.waitForElementVisible(o, timeout)
        WebUI.setText(o, value)
    }

    @Keyword
    static void verifyWebText(String label, int timeout = 10) {
        WebUI.verifyElementPresent(webText(label), timeout)
    }

    @Keyword
    static void verifyWebFieldPresent(String label, int timeout = 10) {
        WebUI.verifyElementPresent(webField(label), timeout)
    }

    @Keyword
    static void verifyWebFieldNotPresent(String label, int timeout = 3) {
        WebUI.verifyElementNotPresent(webField(label), timeout)
    }

    @Keyword
    static void verifyMobileFieldPresent(String label, int timeout = 10) {
        Mobile.verifyElementExist(mobileField(label), timeout)
    }

    @Keyword
    static void assertEnvironment(String variableName) {
        if (!System.getenv(variableName)) KeywordUtil.markFailedAndStop("Required environment variable is missing: ${variableName}")
    }

    @Keyword
    static String requiredEnvironment(String variableName) {
        String value = System.getenv(variableName)
        if (!value) KeywordUtil.markFailedAndStop("Required environment variable is missing: ${variableName}")
        return value
    }

    @Keyword
    static void verifyWebRequestObserved(String pathFragment, int timeout = 10) {
        long endAt = System.currentTimeMillis() + timeout * 1000L
        boolean observed = false
        while (System.currentTimeMillis() < endAt && !observed) {
            def urls = WebUI.executeJavaScript("return performance.getEntriesByType('resource').map(function(e){return e.name;});", null)
            if (urls instanceof Collection) {
                observed = urls.any { it.toString().contains(pathFragment) }
            }
            if (!observed) WebUI.delay(1)
        }
        if (!observed) KeywordUtil.markFailedAndStop("Expected request containing '${pathFragment}' was not found in browser resource timing. Check the API call and browser timing access.")
    }

    @Keyword
    static void closeWeb() { WebUI.closeBrowser() }

    @Keyword
    static void verifyWebCountByXPath(String xpath, int expected, int timeout = 10) {
        TestObject o = new TestObject('webCount_' + safe(xpath))
        o.addProperty('xpath', ConditionType.EQUALS, xpath)
        WebUI.waitForElementPresent(o, timeout)
        int actual = WebUI.findWebElements(o, timeout).size()
        if (actual != expected) KeywordUtil.markFailedAndStop("Expected ${expected} matching web elements for ${xpath}, found ${actual}.")
    }

    @Keyword
    static void verifyLastWebFieldType(String xpath, String expectedType, int expectedCount, int timeout = 10) {
        TestObject o = new TestObject('webFieldType_' + safe(expectedType))
        o.addProperty('xpath', ConditionType.EQUALS, xpath)
        def fields = WebUI.findWebElements(o, timeout)
        if (fields.size() != expectedCount) {
            KeywordUtil.markFailedAndStop("Expected ${expectedCount} configured fields, found ${fields.size()}.")
        }
        String lastFieldText = fields.get(fields.size() - 1).getText()
        if (!lastFieldText.toLowerCase().contains(expectedType.toLowerCase())) {
            KeywordUtil.markFailedAndStop("The last field card did not contain '${expectedType}'. Actual card text: ${lastFieldText}")
        }
    }

    @Keyword
    static void verifyWebElementDisabled(String label, int timeout = 5) {
        TestObject o = webText(label)
        WebUI.waitForElementPresent(o, timeout)
        boolean disabled = WebUI.getAttribute(o, 'disabled') != null || WebUI.getAttribute(o, 'aria-disabled') == 'true'
        if (!disabled) KeywordUtil.markFailedAndStop("Expected web control '${label}' to be disabled or hidden.")
    }


    @Keyword
    static void attachEvidenceFromGallery(String evidenceLabel = 'Evidence') {
        // The app's gallery/file-picker labels vary by Android version and app implementation.
        tapMobile(evidenceLabel)
        try { tapMobile('Gallery', 3) } catch (Exception ignored) {
            try { tapMobile('Photos', 3) } catch (Exception ignoredAgain) { tapMobile('Images', 3) }
        }
        // Test device must contain a prepared image; select the first visible image thumbnail.
        TestObject image = new TestObject('firstGalleryImage')
        image.addProperty('xpath', ConditionType.EQUALS,
            "//*[@content-desc and (contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'photo') or contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'image'))] | //*[@resource-id and contains(translate(@resource-id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'thumbnail')]")
        Mobile.waitForElementPresent(image, 10)
        Mobile.tap(image, 10)
    }

    @Keyword
    static void setAndroidNetworkEnabled(boolean enabled) {
        // Disable both Wi-Fi and mobile data so a phone cannot silently keep using cellular service.
        // Requires an authorized Android device/emulator and ADB access.
        String command = enabled ? 'enable' : 'disable'
        ['wifi', 'data'].each { service ->
            Process p = new ProcessBuilder('adb', 'shell', 'svc', service, command).redirectErrorStream(true).start()
            String output = p.inputStream.getText('UTF-8')
            int exit = p.waitFor()
            if (exit != 0) KeywordUtil.markFailedAndStop("Could not ${command} Android ${service} (exit ${exit}): ${output}")
        }
        Mobile.delay(2)
    }

    /** Open WeMineOffice without automatically completing login; use for sign-in tests. */
    @Keyword
    static void openWebApp() {
        String url = System.getenv('WEMINEOFFICE_BASE_URL')
        if (!url) KeywordUtil.markFailedAndStop('Set WEMINEOFFICE_BASE_URL to the WeMineOffice test URL.')
        WebUI.openBrowser('')
        WebUI.maximizeWindow()
        WebUI.navigateToUrl(url)
        WebUI.waitForPageLoad(20)
    }

    @Keyword
    static void completeMicrosoftSignInWeb() {
        TestObject email = webField('Email')
        boolean emailPrompt = WebUI.verifyElementPresent(email, 3, FailureHandling.OPTIONAL)
        if (!emailPrompt) return
        String msUser = System.getenv('WEMINE_MS_USERNAME')
        String msPassword = System.getenv('WEMINE_MS_PASSWORD')
        if (!msUser || !msPassword) KeywordUtil.markFailedAndStop('Microsoft sign-in is visible. Configure WEMINE_MS_USERNAME and WEMINE_MS_PASSWORD for a dedicated test account.')
        WebUI.setText(email, msUser)
        try { tapWeb('Next', 5) } catch (Exception ignored) { tapWeb('Continue', 5) }
        TestObject password = webField('Password')
        WebUI.waitForElementVisible(password, 10)
        WebUI.setText(password, msPassword)
        try { tapWeb('Sign in', 10) } catch (Exception ignored) { tapWeb('Sign In', 5) }
        try { tapWeb('No', 3) } catch (Exception ignored) { /* Microsoft stay-signed-in prompt is optional */ }
    }

    @Keyword
    static TestObject webField(String label) {
        TestObject o = new TestObject('webField_' + safe(label))
        String q = xpathLiteral(label)
        String qLower = xpathLiteral(label.toLowerCase())
        o.addProperty('xpath', ConditionType.EQUALS,
            "//input[@aria-label=${q} or @placeholder=${q} or @name=${q} or @id=${q} or contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower}) or contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),${qLower})] | //textarea[@aria-label=${q} or @placeholder=${q} or @name=${q} or @id=${q}] | //input[preceding::label[normalize-space(.)=${q}] or following-sibling::label[normalize-space(.)=${q}]]")
        return o
    }

    @Keyword
    static void verifyWebTextNotPresent(String label, int timeout = 3) {
        WebUI.verifyElementNotPresent(webText(label), timeout)
    }

    @Keyword
    static void assertWebFieldCount(String xpath, int expected, int timeout = 10) {
        TestObject o = new TestObject('count_' + safe(xpath))
        o.addProperty('xpath', ConditionType.EQUALS, xpath)
        WebUI.waitForPageLoad(timeout)
        int actual = WebUI.findWebElements(o, timeout).size()
        if (actual != expected) KeywordUtil.markFailedAndStop("Expected ${expected} matching fields but found ${actual}. Check WEMINE_WEB_FIELD_XPATH against the live form-builder DOM.")
    }

    @Keyword
    static void setWebOffline(boolean offline) {
        def driver = com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver()
        try {
            driver.executeCdpCommand('Network.enable', [:])
            driver.executeCdpCommand('Network.emulateNetworkConditions', [offline: offline, latency: offline ? 0 : 20, downloadThroughput: offline ? 0 : 5000000, uploadThroughput: offline ? 0 : 5000000, connectionType: offline ? 'none' : 'wifi'])
            WebUI.delay(2)
        } catch (Exception e) {
            KeywordUtil.markFailedAndStop('Web offline emulation requires a supported Chromium browser and compatible Katalon/Selenium driver: ' + e.getMessage())
        }
    }

    @Keyword
    static void chooseWebOption(String optionLabel, int timeout = 10) {
        tapWeb(optionLabel, timeout)
    }

    private static String safe(String s) { s.replaceAll('[^A-Za-z0-9_]', '_') }
    private static String xpathLiteral(String s) {
        if (!s.contains("'")) return "'${s}'"
        if (!s.contains('"')) return '"' + s + '"'
        return "concat(" + s.split("'", -1).collect { "'${it}'" }.join(", \"'\", ") + ")"
    }
}
