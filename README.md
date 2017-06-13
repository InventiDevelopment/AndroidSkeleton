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

- [RxJava][rxjava]
- [RxAndroid][rxandroid]
- [Dagger2][dagger]
- [ButterKnife][butterknife]
- [RxBinding][rxbinding]
- [Retrofit][retrofit]
- [Mosby][mosby]
- [Conductor][conductor]

Inspiration & Acknowledgements
-----

Articles
- https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
- https://fernandocejas.com/2015/07/18/architecting-android-the-evolution/
- Everything [Jake Wharton][jakewharton] ever done :)
- https://hackernoon.com/configuring-android-project-little-things-that-matter-d6a9d34c1ce0 (whole series)
- TODO

Repos
- https://github.com/googlesamples/android-architecture
- https://github.com/android10/Android-CleanArchitecture
- https://github.com/sockeqwe/mosby-conductor/tree/master/app

How to use this
-----

TODO

TODO List
-----

- [x] Setup github project
- [x] Add all essential dependencies and make sure everything compiles
- [x] Create Main activity as an conductor host
- [x] Create first example screen with view(conductor), presenter
- [x] Translate everything to kotlin
- [X] Setup dagger for everything
- [X] Setup leakCanary
- [X] Setup retrofit with first api call
- [X] Architect use cases and domain logic
- [X] Architect Repository and data layer
- [ ] Remote error handling
- [ ] Correct repository data source observable composition
- [ ] Presenter subscription management and config change
- [ ] Configuration change data management
- [ ] All the preparations for for testing(mock flavour etc)
- [ ] Write unit and UI tests
- [ ] Firebase branch



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
[jakewharton]: https://github.com/JakeWharton
[rxjava]: https://github.com/ReactiveX/RxJava
[rxandroid]: https://github.com/ReactiveX/RxAndroid
[dagger]: https://github.com/google/dagger
[butterknife]: https://github.com/JakeWharton/butterknife
[rxbinding]: https://github.com/JakeWharton/RxBinding
[retrofit]: https://github.com/square/retrofit
[mosby]: https://github.com/sockeqwe/mosby
[conductor]: https://github.com/bluelinelabs/Conductor