// Leave Location, Sublocation, Area and Evidence empty; PIC is expected to default to reporter.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Report Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Submit Hazard')
    // PIC is preselected to the reporter by requirement, so it should not fail this empty-form validation.
    ['Location', 'Sublocation', 'Area', 'Evidence'].each { label ->
        CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(label, 5)
    }
    // The brief does not specify the exact validation copy; confirm submission is blocked instead.
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Submitted', 3)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Follow-up', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
