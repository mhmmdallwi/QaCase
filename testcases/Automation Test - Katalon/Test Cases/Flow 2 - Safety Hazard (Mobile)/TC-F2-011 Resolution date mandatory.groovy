// Preconditions: assigned PIC; open follow-up task; complete other required fields but do not set Resolution Date.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Follow-up')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Open Task')
    CustomKeywords.'wemine.WeMineKeywords.attachEvidenceFromGallery'('Resolution Evidence')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Submit Follow-up')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Resolution Date', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('required', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Resolved', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
