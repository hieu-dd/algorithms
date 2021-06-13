import 'dart:math';

void main() {
  var arr = <int>[2, 10, 3, 1, 4, 1, 5, 9, 2, 6, 5, 4];
  print(mergerSort(arr));
}

List<int> mergerSort(List<int> arr) {
  if (arr.length == 1) {
    return arr;
  } else {
    var leftArr = mergerSort(arr.sublist(0, arr.length ~/ 2));
    var rightArr = mergerSort(arr.sublist(arr.length ~/ 2, arr.length));
    return merge(leftArr, rightArr);
  }
}

List<int> merge(List<int> left, List<int> right) {
  var result = <int>[];
  while (left.isNotEmpty || right.isNotEmpty) {
    if (left.isEmpty) {
      result.add(right[0]);
      right.removeAt(0);
    } else if (right.isEmpty) {
      result.add(left[0]);
      left.removeAt(0);
    } else if (left[0] > right[0]) {
      result.add(right[0]);
      right.removeAt(0);
    } else {
      result.add(left[0]);
      left.removeAt(0);
    }
  }
  return result;
}
