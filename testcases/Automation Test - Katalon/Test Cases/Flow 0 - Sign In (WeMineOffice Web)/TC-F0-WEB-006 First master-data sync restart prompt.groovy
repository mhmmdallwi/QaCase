// Preconditions: clear the browser site data or use a test profile that has not completed its first master-data update.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startWeb'()
try {
    String promptText = System.getenv('WEMINE_RESTART_PROMPT_TEXT') ?: 'restart'
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'(promptText, 60)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
