import cv2

default_folder = "Images/"


def load_file(filename, ext, folder=default_folder):
    return cv2.cvtColor(cv2.imread("{0}{1}.{2}".format(folder, filename, ext)), cv2.COLOR_BGR2RGB)
