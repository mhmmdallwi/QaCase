// Preconditions: sign in as the assigned PIC; a follow-up task notification exists for the test hazard.
// TC-F2-001 or approved test-data setup must create the hazard/task before this recipient-side assertion.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Notifications')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Follow-up', 15)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'), 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
