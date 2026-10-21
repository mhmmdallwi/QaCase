// Preconditions: signed-in session and at least one historical inspection in the test account.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Equipment Inspection')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Previous', 15)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('New Inspection', 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
