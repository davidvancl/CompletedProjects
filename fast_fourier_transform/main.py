import numpy as np
import matplotlib.pyplot as plt


def DFT1D(function):
    F = np.zeros(function.shape, dtype=np.complex64)
    n = function.shape[0]
    x = np.arange(n)
    for u in x:
        F[u] = np.sum(function * np.exp((-1j * 2 * np.pi * u * x) / n))
    return F / np.sqrt(n)


def example1():
    t = np.arange(0, 1, 0.005)
    f = 1 * np.sin(t * (2 * np.pi) * 2) + 0.6 * np.cos(t * (2 * np.pi) * 8) + 0.4 * np.cos(t * (2 * np.pi) * 4)

    # plt.figure(figsize=(10, 4))
    # plt.plot(t, f)
    # plt.show()

    dft_t = np.arange(32)
    dft_f = DFT1D(f)

    plt.figure(figsize=(10, 4))
    plt.plot(dft_t, np.abs(dft_f[:32]))
    plt.show()


if __name__ == '__main__':
    example1()
