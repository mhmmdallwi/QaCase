// Preconditions: published form with required fields; valid values and a test image are available.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Equipment Inspection')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('New Inspection')
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Form Code', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_EQUIPMENT_FORM_CODE'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Load Form')
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Inspection Notes', 'Automated inspection test')
    CustomKeywords.'wemine.WeMineKeywords.tapMobileField'('Inspection Date')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Today')
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Condition', 'Good')
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Result', 'Pass')
    CustomKeywords.'wemine.WeMineKeywords.attachEvidenceFromGallery'()
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Submit Inspection')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Submitted', 20)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
