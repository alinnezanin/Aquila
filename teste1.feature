Feature: Teste da FSM

Background:
    When Parte click[aaa]

Scenario: ramo 1
    When Parte 2
    And Parte 3
    And Parte 4
    Then Parte 5

Scenario: ramo2
    Given Parte 6 use-valid-data:
    |cabecalho| cabecalho2 |
    |Maria| 13 |
    |João| 12 |
    And Parte 7
    Then Parte 8
    Then Parte 9 use-valid-data:
    |cabecalho| cabecalho2 |
    |R1| R2 |
    |A1| A2 |

Scenario: ramo3
    Given P1
    Then p2{ramo 1}
    Then p3