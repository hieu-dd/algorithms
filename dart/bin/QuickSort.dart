void main() {
  var arr = <int>[2, 10, 3, 1, 4, 1, 5, 9, 2, 6, 5, 4];
  quickSort(arr, 0, arr.length - 1);
  print(arr);
}

void quickSort(List<int> arr, int start, int end) {
  var left = start;
  var right = end;
  if (left >= right) return;
  var pivotIndex = (left + right) ~/ 2;
  var pivot = arr[pivotIndex];
  while (true) {
    while (arr[left] < pivot) {
      left++;
    }
    while (arr[right] > pivot) {
      right--;
    }
    if (right < left) break;
    var temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
  }

  quickSort(arr, start, left - 1);
  quickSort(arr, left, end);
}

void sort() {}
