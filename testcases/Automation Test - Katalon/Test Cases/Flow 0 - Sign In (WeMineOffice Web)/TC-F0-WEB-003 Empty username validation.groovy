// Leave Username empty and continue from the initial sign-in screen.
CustomKeywords.'wemine.WeMineKeywords.openWebApp'()
try {
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Continue', 5) } catch (Exception ignored) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Next', 5) }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldPresent'('Username', 5)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldNotPresent'('Email', 3)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldNotPresent'('Password', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
