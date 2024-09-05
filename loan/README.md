## Configuraciones del circuit breaker

 ```  
- failureRateThreshold—Expected percentage of the failure threshold.
I have set it as 50%. It means, when total failed remote calls % is equal or greater than 50%, 
breaker will be active to stop furthermore requests.
- minimumNumberOfCalls — Minimum number of total API calls to decide failure 
percentage to enable the breaker.
I have set it as 5. Let’s say 3 API calls are failing from the the first 5 API calls. 
It means failureRateThreshold = (3/5) * 100 = 60%.
- automaticTransitionFromOpenToHalfOpenEnabled — I have set this as true. 
It will automatically transfer OPEN state to HALF OPEN state when it comes the right time for that transition.
- waitDurationInOpenState — Timeout period before going to HALF OPEN state from OPEN state. 
After 5 seconds, breaker will change the state, here.
- permittedNumberOfCallsInHalfOpenState — Number of LIMITED API calls that should be sent while 
in HALF OPEN state. I have set it as 3. So, after 3 API calls, if they are failed, then breaker will again go to OPEN state. 
Otherwise breaker will be CLOSED since rate-service is UP.
- slidingWindowType: Here I have set the type to keep the circuit breaker behavior based 
on the requests counts.

 ``` 