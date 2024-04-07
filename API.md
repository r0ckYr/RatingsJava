# Rating System API Documentation

## Mentor API

### Create Mentor
- **URL:** `/api/v1/mentor/create`
- **Method:** `POST`
- **Request Body:** Mentor object
- **Description:** Creates a new mentor.
- **Response:** Newly created mentor object with HTTP status `200 OK`.

### Get All Mentors
- **URL:** `/api/v1/mentor/all`
- **Method:** `GET`
- **Description:** Retrieves all mentors.
- **Response:** List of mentor objects with HTTP status `200 OK`.

### Rate Mentor
- **URL:** `/api/v1/mentor/rate`
- **Method:** `POST`
- **Request Body:** RateRequest object containing mentorId and rating
- **Description:** Rates a mentor.
- **Response:** Success message with HTTP status `200 OK`.

### Get Mentors by Rating
- **URL:** `/api/v1/mentor/all?rating={rating}`
- **Method:** `GET`
- **Query Parameter:** `rating` (optional) - Filter mentors by rating.
- **Description:** Retrieves mentors filtered by rating.
- **Response:** List of mentor objects with specified rating with HTTP status `200 OK`.

### Get Mentors with Reviews
- **URL:** `/api/v1/mentor/all?rating={rating}`
- **Method:** `GET`
- **Query Parameter:** `rating` (optional) - Filter mentors by rating.
- **Description:** Retrieves mentors along with their reviews.
- **Response:** List of MentorReviewResponse objects with specified rating with HTTP status `200 OK`.

## Recommendation API

### Create Recommendation
- **URL:** `/api/v1/recommendation/create`
- **Method:** `POST`
- **Request Body:** RecommendRequest object
- **Description:** Creates a new recommendation for a student.
- **Response:** Newly created RecommendStudent object with HTTP status `200 OK`.

### Get All Recommendations
- **URL:** `/api/v1/recommendation/all`
- **Method:** `GET`
- **Description:** Retrieves all recommendations.
- **Response:** List of RecommendStudent objects with HTTP status `200 OK`.

### Get Recommendation by ID
- **URL:** `/api/v1/recommendation/{recommendationID}`
- **Method:** `GET`
- **Path Parameter:** `recommendationID` - ID of the recommendation.
- **Description:** Retrieves a recommendation by its ID.
- **Response:** RecommendStudent object with specified ID with HTTP status `200 OK`, or `404 NOT FOUND` if not found.

## Review API

### Create Review
- **URL:** `/api/v1/review/create`
- **Method:** `POST`
- **Request Body:** ReviewRequest object
- **Description:** Creates a new review for a mentor.
- **Response:** Success message with HTTP status `200 OK`.

## User API

### Create User
- **URL:** `/api/v1/user/create`
- **Method:** `POST`
- **Request Body:** User object
- **Description:** Creates a new user.
- **Response:** Newly created user object with HTTP status `200 OK`.

### Get All Users
- **URL:** `/api/v1/user/all`
- **Method:** `GET`
- **Description:** Retrieves all users.
- **Response:** List of user objects with HTTP status `200 OK`.

## Model Classes

### Mentor
- **Fields:**
  - `id` (Long): Unique identifier for the mentor.
  - `name` (String): Name of the mentor.
  - `numberOfRatings` (double): Total number of ratings received by the mentor.
  - `overallRating` (double): Overall rating of the mentor.
- **Description:** Represents a mentor in the system.

### RecommendStudent
- **Fields:**
  - `id` (Long): Unique identifier for the recommendation.
  - `studentName` (String): Name of the student receiving the recommendation.
  - `letterOfRecommendation` (String): Content of the recommendation letter.
- **Description:** Represents a recommendation for a student in the system.

### Review
- **Fields:**
  - `id` (Long): Unique identifier for the review.
  - `mentor` (Mentor): Mentor being reviewed.
  - `user` (User): User submitting the review.
  - `comment` (String): Comment provided in the review.
  - `rating` (int): Rating given in the review.
- **Description:** Represents a review submitted by a user for a mentor in the system.

### User
- **Fields:**
  - `id` (Long): Unique identifier for the user.
  - `name` (String): Name of the user.
- **Description:** Represents a user in the system.


## DTO Classes

### MentorReviewResponse
- **Fields:**
  - `mentor` (Mentor): Mentor object.
  - `reviews` (List<Review>): List of review objects for the mentor.
- **Description:** Represents a response object containing a mentor and their reviews.

### RateRequest
- **Fields:**
  - `mentorId` (long): ID of the mentor to be rated.
  - `rating` (int): Rating to be given to the mentor.
- **Description:** Represents a request object for rating a mentor.

### RecommendRequest
- **Fields:**
  - `studentName` (String): Name of the student to be recommended.
  - `letterOfRecommendation` (String): Content of the recommendation letter.
- **Description:** Represents a request object for recommending a student.

### ReviewRequest
- **Fields:**
  - `userId` (Long): ID of the user submitting the review.
  - `mentorId` (Long): ID of the mentor being reviewed.
  - `comment` (String): Comment provided in the review.
- **Description:** Represents a request object for submitting a review.
