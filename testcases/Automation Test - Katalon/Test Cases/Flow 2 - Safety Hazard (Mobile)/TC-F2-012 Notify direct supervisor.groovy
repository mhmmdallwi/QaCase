// Preconditions: sign in as the area's direct supervisor; the PIC has already resolved a follow-up task.
// TC-F2-010 or approved test-data setup must complete the task before this recipient-side assertion.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Notifications')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Follow-up', 15)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Resolved', 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
