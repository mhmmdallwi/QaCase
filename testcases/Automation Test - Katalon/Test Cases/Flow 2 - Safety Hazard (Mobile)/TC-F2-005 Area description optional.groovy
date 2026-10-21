// Preconditions: valid master data and test image in gallery; leave Area Description empty.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Report Hazard')
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Location', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Sublocation', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_SUBLOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Area', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_AREA'))
    CustomKeywords.'wemine.WeMineKeywords.attachEvidenceFromGallery'()
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Submit Hazard')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Submitted', 20)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
