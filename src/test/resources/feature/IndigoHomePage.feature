Feature: Flight Search
Scenario Outline: Validate homepage function
Given launch site using "<bn>" 
Then title should be "IndiGo"
When click radio button "<rb>"
Then validate radiobutton clicked
When enter from place "<fplc>"
And enter to place "<tplc>"
And enter from date "<fdate>"
And enter to date "<tdate>"
And click search
Then validate flight details page should be opend
And close site
Examples:
|      bn       |        rb     |       fplc     |     tplc      |    fdate     |    tdate     |
|   chrome      |    roundtrip  |        Goa     |   Hyderabad   | 28-May-2020  |  29-Aug-2020 |
|   chrome      |    roundtrip  |      Mumbai    |   Hyderabad   | 28-May-2020  |  29-Aug-2020 |
|   Firefox     |    oneway     |      Muscat    |   Hyderabad   | 15-Jun-2020  |              |
|   Opera       |    roundtrip  |       Delhi    |   Vijayawada  | 3-Jul-2020   | 27-Mar-2021  |
