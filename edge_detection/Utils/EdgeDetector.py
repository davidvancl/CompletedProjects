import cv2
import csv


class EdgeDetector:
    def __init__(self):
        self.original = None
        self.image = None

    def loadFile(self, path):
        self.original = cv2.imread(path)
        self.image = self.original.copy()

    def convertToGray(self):
        self.image = cv2.cvtColor(self.image, cv2.COLOR_BGR2GRAY)

    def getOriginal(self):
        return self.original

    def getImage(self):
        return self.image

    def saveAsCsc(self, name):
        with open("%s.csv" % name, 'w', newline='') as file:
            csv_out = csv.writer(file)
            for i in range(0, len(self.image)):
                csv_out.writerow(self.image[i])

    def process(self):
        self.convertToGray()
        self.image = cv2.GaussianBlur(self.image, (3, 3), 0)
        return cv2.Sobel(src=self.image, ddepth=cv2.CV_64F, dx=1, dy=1, ksize=5)
