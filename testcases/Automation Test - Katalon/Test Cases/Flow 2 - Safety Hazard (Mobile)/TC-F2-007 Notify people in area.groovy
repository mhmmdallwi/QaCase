// Preconditions: sign in as a recipient assigned to the selected area; a new hazard notification fixture exists.
// Create the hazard with TC-F2-001 or the approved test-data setup before running this recipient-side assertion.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Notifications')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Hazard', 15)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'), 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
