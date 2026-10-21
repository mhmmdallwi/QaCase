CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Equipment Inspection')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('New Inspection')
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Form Code', 'INVALID-FORM-CODE-000')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Load Form')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileFieldPresent'('Form Code', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Submit Inspection', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
