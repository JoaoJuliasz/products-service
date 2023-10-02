# Order API Filter Service

This is a REST service that filters data from the Order API based on the parameters sent via HTTP requests. The service allows you to specify a date range using the `begindate` and `finaldate` parameters in the request URL, and it returns a filtered list of items from the Order API that fall within that date range.

## Technologies

- Kotlin
- Spring Boot

## Installation and Setup

1. Clone this repository to your local machine.

   ```shell
   git clone https://github.com/joaojuliasz/products-service.git
   ```

2. Navigate to the project directory.

   ```shell
   cd products-service
   ```

3. Build the project.

   ```shell
   ./gradlew build
   ```

4. Run the service.

   ```shell
   ./gradlew bootRun
   ```

This will start the service, and you can access it at `http://localhost:8080/challenge-backend/item` with the appropriate date range parameters as specified in the Usage section of the README.

If you encounter any issues or have questions, please feel free to reach out for assistance.

## Usage

### Filtering by Date Range

To filter items from the Order API by a date range, send a GET request to the following URL format:

```
GET http://localhost:8080/challenge-backend/item?begindate=<start_date>&finaldate=<end_date>
```

Replace `<start_date>` and `<end_date>` with the desired date range in the format `dd-MM-yyyy`. For example:

```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```

### Response

The service will respond with a JSON array containing the filtered items from the Order API that match the specified date range. Each item in the response includes the following fields:

- `name`: The name of the item.
- `code`: The item code.
- `date`: The date of the item.
- `dimension`: The dimensions of the item, including weight, height, width, and length.

Example response:

```json
[
  {
    "name": "Impressora",
    "code": "5",
    "date": "2016-10-05T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  {
    "name": "Fifa2017",
    "code": "6",
    "date": "2016-10-06T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  }
]
```
