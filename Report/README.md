# Report: Error Analysis
## Intro to Programming 360-420: Section 02
## William Tang and Jason Dinh

## Distributions of Model Accuracy, k = 3, over 1000 iterations

| Model      | Accuracy (%)  | Standard Deviation |
| ---------- | ------------- | ------------------ |
| kNN        | 96.52854      | 1.30806            |
| Baseline   | 65.23073      | 8.09477E-4         |

### Baseline comparison
  A sensible baseline to compare our model's performance to is just to count the most frequent class in the set, and use that as a prediction every single time. Also called the [zero rule algorithm](https://machinelearningcatalogue.com/algorithm/alg_zero-rule.html), this baseline is a better than just going 50/50 every time for a prediction. For example, if 60% of the points in the set are of one class, the zero rule algorithm supposes that every other point in the set has that class label as well.
  
  As the results show, the baseline accuracy is actually around 65%. The kNN classifier got an average accuracy of around 96.5% with a standard deviation of 1.31. This is a significant increase in accuracy from the baseline.
  
## Analysis of different error types
