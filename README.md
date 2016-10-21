# DataBinarization
##.domain file
An example:
```
15
C 17.0 90.0 16
D Federal-gov Local-gov State-gov Private Self-emp-inc Self-emp-not-inc Without-pay
C 13492.0 1490400.0 16
```
First row is the count of features, from second row, each row is made up of feature value type (C accounts for continuous, D represents discrete) and feature values set, the feature's index in data is it's order here (from 0 to features_count-1)
##How to use data2libsvm.jar?
- Firstly, configure a config file for data by using format:
  ```
  label's index (from 0 to features_count-1)
  the values of the label correspond to be positive (+1)
  ```
  Please see .domain and select a feature as the label and select the values as  
  An example:
  ```
  3
  Some-college Assoc-voc Assoc-acdm Bachelors Masters Prof-school Doctorate
  ```
- Second run data2libsvm to generate new file
  An example:
  ```bash
  java -jar data2libsvm.jar Data2.domain Train2.dat Train2.cfg
  ```
  Then we can see a generated binarized libsvm-format file: Train2.dat.3.libsvm.txt

