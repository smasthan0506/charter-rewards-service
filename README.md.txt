Customer Rewards Service

Overview

Customer Rewards Service is a Spring Boot REST API that calculates reward points earned by customers based on their transaction history.

The application calculates:
	•	Monthly reward points for each customer
	•	Total reward points across the configured reward period
	•	Rewards for a specific customer
	•	Rewards for all customers

The application uses an H2 in-memory database for storing customer and transaction information.


Reward Calculation Rules

A customer receives:
	•	2 points for every dollar spent over $100 in a transaction
	•	1 point for every dollar spent between $50 and $100 in a transaction
	•	No points for amounts less than or equal to $50

Examples

Transaction Amount = $120
Reward Points:
	•	$50 - $100 = 50 points
	•	$101 - $120 = 20 × 2 = 40 points

Total Reward Points = 90

Transaction Amount = $220
Reward Points:
	•	$50 - $100 = 50 points
	•	$101 - $220 = 120 × 2 = 240 points

Total Reward Points = 290


Technology Stack
	•	Java 11
	•	Spring Boot
	•	Spring Data JPA
	•	Maven
	•	H2 Database
	•	JUnit 5
	•	Mockito
	•	SLF4J Logging
	
	
	
API Endpoints

Get Rewards for a Customer
GET /api/rewards/{customerId}

Example:
GET /api/rewards/101 

Sample Response
{
    "customerId": 101,
    "customerName": "Masthan",
    "totalRewardPoints": 340,
    "monthlyRewards": [
        {
            "month": "APRIL",
            "rewardPoints": 40
        },
        {
            "month": "MAY",
            "rewardPoints": 210
        },
        {
            "month": "MARCH",
            "rewardPoints": 90
        }
    ]
}

Get Rewards for All Customers


GET /api/rewards/customers
Sample Response

