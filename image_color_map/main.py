import cv2
import FileManager
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans
from collections import Counter


def RGB2HEX(color):
    return "#{:02x}{:02x}{:02x}".format(int(color[0]), int(color[1]), int(color[2]))


if __name__ == '__main__':
    image = FileManager.load_file("test", "png")
    modified_image = cv2.resize(image, (600, 400), interpolation=cv2.INTER_AREA)
    modified_image = modified_image.reshape(modified_image.shape[0]*modified_image.shape[1], 3)
    clf = KMeans(n_clusters=4)
    labels = clf.fit_predict(modified_image)
    counts = Counter(labels)
    center_colors = clf.cluster_centers_
    ordered_colors = [center_colors[i] for i in counts.keys()]
    hex_colors = [RGB2HEX(ordered_colors[i]) for i in counts.keys()]
    rgb_colors = [ordered_colors[i] for i in counts.keys()]
    plt.figure(figsize=(8, 6))
    plt.pie(counts.values(), labels=hex_colors,colors=hex_colors)
    plt.show()
