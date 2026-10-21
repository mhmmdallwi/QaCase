// Preconditions: form code exists in tenant master data.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Equipment Inspection')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('New Inspection')
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Form Code', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_EQUIPMENT_FORM_CODE'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Load Form')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Inspection Notes', 15)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
