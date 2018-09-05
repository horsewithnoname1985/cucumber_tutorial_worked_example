$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cash_withdrawal.feature");
formatter.feature({
  "name": "Cash withdrawal",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful withdrawal from an account in credit",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have deposited $100.00 in my account",
  "keyword": "Given "
});
formatter.match({
  "location": "AccountSteps.iHaveDeposited$InMyAccount(Money)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I withdraw $20",
  "keyword": "When "
});
formatter.match({
  "location": "TellerSteps.iWithdraw$(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "$20 should be dispensed",
  "keyword": "Then "
});
formatter.match({
  "location": "CashSlotSteps.$ShouldBeDispensed(int)"
});
formatter.result({
  "status": "passed"
});
});