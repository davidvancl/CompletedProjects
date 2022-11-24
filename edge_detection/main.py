import cv2
from PIL import Image
import PIL.ImageOps

if __name__ == '__main__':
    original = cv2.imread("Images/tmp.jpg")
    gray = cv2.cvtColor(original, cv2.COLOR_BGR2GRAY)
    image = cv2.GaussianBlur(gray, (3, 3), 0)
    # sobel = cv2.Sobel(src=image, ddepth=cv2.CV_64F, dx=1, dy=1, ksize=5)

    canny = cv2.Canny(image=image, threshold1=100, threshold2=200)
    # cv2.imshow('Sobel', canny)
    # cv2.waitKey(0)
    cv2.imwrite('Images/result.jpg', canny)

    image = Image.open('Images/result.jpg')
    inverted_image = PIL.ImageOps.invert(image)
    inverted_image.save('Images/result.jpg')

