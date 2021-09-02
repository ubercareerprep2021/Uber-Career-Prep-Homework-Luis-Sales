package Assignment3.search

class SearchEx3 {

    // This function calculates base^power recursively. It does so because by adhering to the following property:
    // n^m == n^(m/2) * n^(m/2) if m is even, otherwise, n^m == n^(m/2) * n^(m/2) * n.
    fun pow(base: Double, power: Int) : Double {
        if (base == 0.0) {
            if (power < 0) throw ArithmeticException()
            if (power == 0) return 1.0
            return 0.0
        }

        return if (power >= 0) {
            powHelper(base, power)
        } else {
            1.0 / powHelper(base, power)
        }
    }

    fun powHelper(base: Double, power: Int) : Double{
        if (power == 0) return 1.0
        if (power == 1) return base

        val result = powHelper(base, power/2)
        return if (power % 2 == 0) {
            result * result
        } else {
            result * result * base
        }
    }

}