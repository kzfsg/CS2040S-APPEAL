NodleService1 (I checked the test cases provided)
Output:


31
-1
50
31
16

NodleService2 (I printed out the various states of students)
Output:

Adding Student 31:
Start Time: 2
Start Distance: 6
Rate: 3
Arrival Time: 4

Tree after adding Student 31:
└── Time: 3, Student ID: 31
    ├── Time: 2, Student ID: 31
    └── Time: 4, Student ID: 31

State Table:
Time | Student Distances | Next Student
-----|------------------|-------------
   0 |                  | 31
   1 |                  | 31
   2 | S31:6            | 31
   3 | S31:3            | 31
   4 | S31:0            | 31

Adding Student 16:
Start Time: 1
Start Distance: 6
Rate: 1
Arrival Time: 7

Tree after adding Student 16:
└── Time: 3, Student ID: 31
    ├── Time: 2, Student ID: 16
    │   ├── Time: 1, Student ID: 16
    └── Time: 5, Student ID: 16
        ├── Time: 4, Student ID: 31
        └── Time: 6, Student ID: 16
            └── Time: 7, Student ID: 16

State Table:
Time | Student Distances | Next Student
-----|------------------|-------------
   0 |                  | 16
   1 | S16:6            | 16
   2 | S31:6 S16:5      | 16
   3 | S31:3 S16:4      | 31
   4 | S31:0 S16:3      | 31
   5 | S16:2            | 16
   6 | S16:1            | 16
   7 | S16:0            | 16

Adding Student 50:
Start Time: 1
Start Distance: 1
Rate: 1
Arrival Time: 2

Tree after adding Student 50:
└── Time: 3, Student ID: 31
    ├── Time: 2, Student ID: 50
    │   ├── Time: 1, Student ID: 50
    └── Time: 5, Student ID: 16
        ├── Time: 4, Student ID: 31
        └── Time: 6, Student ID: 16
            └── Time: 7, Student ID: 16

State Table:
Time | Student Distances | Next Student
-----|------------------|-------------
   0 |                  | 50
   1 | S16:6 S50:1      | 50
   2 | S31:6 S16:5 S50:0 | 50
   3 | S31:3 S16:4      | 31
   4 | S31:0 S16:3      | 31
   5 | S16:2            | 16
   6 | S16:1            | 16
   7 | S16:0            | 16

Final Test Results:
----------------
answer(1) = 50
answer(4) = 31
answer(5) = 16
