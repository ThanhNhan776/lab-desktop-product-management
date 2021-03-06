USE [master]
GO
/****** Object:  Database [Lab_ProductManagement]    Script Date: 1/13/2021 22:43:10 ******/
CREATE DATABASE [Lab_ProductManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Lab_ProductManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Lab_ProductManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Lab_ProductManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Lab_ProductManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Lab_ProductManagement] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Lab_ProductManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Lab_ProductManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Lab_ProductManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Lab_ProductManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Lab_ProductManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Lab_ProductManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [Lab_ProductManagement] SET  MULTI_USER 
GO
ALTER DATABASE [Lab_ProductManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Lab_ProductManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Lab_ProductManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Lab_ProductManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Lab_ProductManagement] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Lab_ProductManagement', N'ON'
GO
ALTER DATABASE [Lab_ProductManagement] SET QUERY_STORE = OFF
GO
USE [Lab_ProductManagement]
GO
/****** Object:  Table [dbo].[TblCategories]    Script Date: 1/13/2021 22:43:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblCategories](
	[categoryId] [varchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TblProducts]    Script Date: 1/13/2021 22:43:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblProducts](
	[productId] [varchar](10) NOT NULL,
	[productName] [nvarchar](50) NULL,
	[unit] [nvarchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[categoryId] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TblUsers]    Script Date: 1/13/2021 22:43:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblUsers](
	[userId] [varchar](10) NOT NULL,
	[fullName] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[TblCategories] ([categoryId], [categoryName], [description]) VALUES (N'CELLPHONE', N'Cell phone', N'Cell phone, mobile phone')
INSERT [dbo].[TblCategories] ([categoryId], [categoryName], [description]) VALUES (N'HEADPHONE', N'Head phone', N'Head phone, ear phone')
INSERT [dbo].[TblCategories] ([categoryId], [categoryName], [description]) VALUES (N'LAPTOP', N'Laptop', N'Laptop, personal computer')
INSERT [dbo].[TblProducts] ([productId], [productName], [unit], [price], [quantity], [categoryId]) VALUES (N'P01', N'Laptop Dell', N'$', 100.5, 10, N'LAPTOP')
INSERT [dbo].[TblProducts] ([productId], [productName], [unit], [price], [quantity], [categoryId]) VALUES (N'P02', N'Laptop HP', N'$', 150.4, 20, N'LAPTOP')
INSERT [dbo].[TblProducts] ([productId], [productName], [unit], [price], [quantity], [categoryId]) VALUES (N'P03', N'Xiaomi note 5', N'$', 50.2, 30, N'CELLPHONE')
INSERT [dbo].[TblUsers] ([userId], [fullName], [password], [status]) VALUES (N'user01', N'Bill Gates', N'user01', 1)
INSERT [dbo].[TblUsers] ([userId], [fullName], [password], [status]) VALUES (N'user02', N'Elon Musk', N'user02', 1)
INSERT [dbo].[TblUsers] ([userId], [fullName], [password], [status]) VALUES (N'user03', N'Mark Zuckerberg', N'user03', 0)
ALTER TABLE [dbo].[TblProducts]  WITH CHECK ADD FOREIGN KEY([categoryId])
REFERENCES [dbo].[TblCategories] ([categoryId])
GO
USE [master]
GO
ALTER DATABASE [Lab_ProductManagement] SET  READ_WRITE 
GO
