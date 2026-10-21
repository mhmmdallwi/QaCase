// Preconditions: sign in as assigned PIC; an open follow-up task exists; image is available in gallery.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Follow-up')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Open Task')
    CustomKeywords.'wemine.WeMineKeywords.attachEvidenceFromGallery'('Resolution Evidence')
    CustomKeywords.'wemine.WeMineKeywords.tapMobileField'('Resolution Date')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Today')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(System.getenv('WEMINE_ADD_CO_OBSERVER_LABEL') ?: '+')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_CO_OBSERVER_1'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Submit Follow-up')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Resolved', 20)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
