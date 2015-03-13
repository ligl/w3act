Feature: Exporting Targets
  As a user with a list of Targets on View
  I want to be able to export them into a format
  So that I can view the results

Scenario: Exporting Targets to CSV Format
  Given I have a list of Target result on view
  When I choose the export function
  Then I should see headings with "nid" "title" "field_url" "author" "field_crawl_frequency" "created"
  And data with "1" "BBC Target title" "http://www.bbc.co.uk/test1" "Bob" "MONTHLY" "Wed Feb 01 00:00:00 UTC 2012"
