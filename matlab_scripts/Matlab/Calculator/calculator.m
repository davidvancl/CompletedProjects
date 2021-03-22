function varargout = calculator(varargin)
% CALCULATOR MATLAB code for calculator.fig
%      CALCULATOR, by itself, creates a new CALCULATOR or raises the existing
%      singleton*.
%
%      H = CALCULATOR returns the handle to a new CALCULATOR or the handle to
%      the existing singleton*.
%
%      CALCULATOR('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in CALCULATOR.M with the given input arguments.
%
%      CALCULATOR('Property','Value',...) creates a new CALCULATOR or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before calculator_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to calculator_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help calculator

% Last Modified by GUIDE v2.5 17-Jan-2020 11:16:25

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @calculator_OpeningFcn, ...
                   'gui_OutputFcn',  @calculator_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);         
               
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before calculator is made visible.
function calculator_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to calculator (see VARARGIN)

% Choose default command line output for calculator
handles.output = hObject;

% Update handles structure
guidata(hObject, handles); 

% UIWAIT makes calculator wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = calculator_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function setObjectToWindows(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
x = hObject.String;
if ~any([strcmp(x, '1'), strcmp(x, '2'), strcmp(x, '3'),strcmp(x, '4'),strcmp(x, '5'),strcmp(x, '6'),strcmp(x, '7'),strcmp(x, '8'),strcmp(x, '9'),strcmp(x, '0'),strcmp(x, '.'),strcmp(x, '('),strcmp(x, ')')])
    val=hObject.String;
    if strcmp(val, "PI")==1
        val="pi";
    end
    if strcmp(val, "cotan")==1
        val="atan(";
    end
    if strcmp(val, "cos")==1
        val="cos(";
    end
    if strcmp(val, "sin")==1
        val="sin(";
    end
    if strcmp(val, "sin")==1
        val="sin(";
    end
    if strcmp(val, "e")==1
        val="exp(1)";
    end
    if strcmp(val, "log")==1
        val="log(";
    end
    handles.text3.String = strcat(handles.text3.String,{' '},val,{' '});
else
    handles.text3.String = strcat(handles.text3.String,hObject.String);
end


% --- Executes on button press in pushbutton12.
function evaluateString(hObject, eventdata, handles)
% hObject    handle to pushbutton12 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
try
    handles.text4.String = handles.text3.String;
    newCommand = string(strrep(handles.text3.String,{' '},''));
    handles.text3.String = eval(newCommand);
catch exception 
   handles.text3.String = "Incorrect syntax";
end


% --- Executes on button press in pushbutton4.
function clearCommands(hObject, eventdata, handles)
% hObject    handle to pushbutton4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
if strcmp(handles.text3.String, "Incorrect syntax")==1
    handles.text3.String = strtrim(handles.text4.String);
else
    tmpArray = split(handles.text3.String," ");
    newString = "";
    for i=1:length(tmpArray) - 1
        newString = strcat(newString," ",tmpArray(i));
    end
    handles.text3.String = strtrim(newString);
end
