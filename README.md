Android Skeleton
========

Simple template app based on [jsonplaceholder][jsonplaceholder] example REST API.


Goals
-----

TODO explain our goals

Architecture
-----

We use simplified version of clean architecture.

- Data - not sure yet how to handle this layer in this template, this can be different from app to app so it may be appropriate to use something simple like `SharedPreferences` or we can create more flavours(branches?) of this layer
- Domain - Use cases and stuff
- Presentation - MVP maybe parts of MVI on some complex forms

Glue between these layers is RxJava
Package by feature inside every main layer

Used libraries
-----

RxJava
Dagger
ButterKnife
Mosby
Conductor
TODO

Inspiration
-----

TODO links to other repos


How to use this
-----

TODO

TODO List
-----

- [x] First
- [ ] Second
- [ ] Third


License
-------

    Copyright 2017 Inventi Development s.r.o

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[jsonplaceholder]: https://jsonplaceholder.typicode.com/