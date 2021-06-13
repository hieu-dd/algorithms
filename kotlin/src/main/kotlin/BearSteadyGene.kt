import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


/*
    https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
 */

fun steadyGene(gene: String): Int {

    val geneArr = gene.toCharArray()
    val size = geneArr.size
    var maxlenght = size / 4
    val arr = arrayOf(geneArr.count { it.toString() == "A" },
        geneArr.count { it.toString() == "C" },
        geneArr.count { it.toString() == "T" },
        geneArr.count { it.toString() == "G" })

    val minSubLength = arr.filter { it > maxlenght }.sumBy { it - maxlenght }
    val newArr = arr.map { if (it > maxlenght) it - maxlenght else 0 }
    println(minSubLength)
    println("${newArr[0]} ${newArr[1]} ${newArr[2]} ${newArr[3]}")
    var min = size
    var right = 0
    var left = 0
    var arr1 = arrayOf(0, 0, 0, 0)
    test@ while (right < size - 1) {
        if (arr1[0] >= newArr[0] && arr1[1] >= newArr[1] && arr1[2] >= newArr[2] && arr1[3] >= newArr[3]) {
            min = Math.min(min, right - left)
            left++
            when {
                geneArr[left].toString() == "A" -> {
                    arr1[0] = arr1[0] - 1
                }
                geneArr[left].toString() == "C" -> {
                    arr1[1] = arr1[1] - 1
                }
                geneArr[left].toString() == "T" -> {
                    arr1[2] = arr1[2] + -1
                }
                geneArr[left].toString() == "G" -> {
                    arr1[3] = arr1[3] - 1
                }
                else -> {
                }
            }
        } else {
            right++
            when {
                geneArr[right].toString() == "A" -> {
                    arr1[0] = arr1[0] + 1
                }
                geneArr[right].toString() == "C" -> {
                    arr1[1] = arr1[1] + 1
                }
                geneArr[right].toString() == "T" -> {
                    arr1[2] = arr1[2] + 1
                }
                geneArr[right].toString() == "G" -> {
                    arr1[3] = arr1[3] + 1
                }
                else -> {
                }
            }
        }
    }
    return min
}

fun main(args: Array<String>) {
    val gene = "TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC"
    val result = steadyGene(gene)
    println(result)
}